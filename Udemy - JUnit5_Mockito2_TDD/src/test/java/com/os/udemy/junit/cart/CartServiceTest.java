package com.os.udemy.junit.cart;

import com.os.udemy.junit.order.Order;
import static org.hamcrest.MatcherAssert.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import com.os.udemy.junit.order.OrderStatus;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;
@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartHandler cartHandler;

    @Captor
    ArgumentCaptor<Cart> argumentCaptor = ArgumentCaptor.forClass(Cart.class);

    @Test
    void processCartShouldSendToPrepare() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        /* no needed because of @InjectMocks and @Mock
        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);
        */
        given(cartHandler.canHandleCart(cart)).willReturn(true);

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        verify(cartHandler).sendToPrepare(cart);
        verify(cartHandler, times(1)).sendToPrepare(cart);
        verify(cartHandler, atLeastOnce()).sendToPrepare(cart);

        InOrder inOrder = inOrder(cartHandler);
        inOrder.verify(cartHandler).canHandleCart(cart);
        inOrder.verify(cartHandler).sendToPrepare(cart);

        then(cartHandler).should().sendToPrepare(cart);

        assertThat(resultCart.getOrders(), hasSize(1));
        resultCart.getOrders().forEach(tmpOrder -> assertThat(tmpOrder.getOrderStatus(), equalTo(OrderStatus.PREPARING)));
    }

    @Test
    void processCartShouldNotSendToPrepare() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(cart)).willReturn(false);

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        verify(cartHandler, never()).sendToPrepare(cart);
        then(cartHandler).should(never()).sendToPrepare(cart);
        resultCart.getOrders().forEach(tmpOrder -> assertThat(tmpOrder.getOrderStatus(), equalTo(OrderStatus.REJECTED)));
    }

    @Test
    void processCartShouldNotSendToPrepareWithArgumentMatcher() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(any(Cart.class))).willReturn(false);

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        verify(cartHandler, never()).sendToPrepare(any(Cart.class));
        then(cartHandler).should(never()).sendToPrepare(any(Cart.class));
        resultCart.getOrders().forEach(tmpOrder -> assertThat(tmpOrder.getOrderStatus(), equalTo(OrderStatus.REJECTED)));
    }

    @Test
    void processCartShouldNotSendToPrepareWithValidationFalse() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(any(Cart.class))).willReturn(false);

        // we cannot mix matcher with real value
        //given(cartHandler.validateCart(any(Cart.class), "String")).willReturn(false);

        // this is OK:
        //given(cartHandler.validateCart(cart, "String")).willReturn(false);

        // and this also fine
        //given(cartHandler.validateCart(any(Cart.class), anyString())).willReturn(false);

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        verify(cartHandler, never()).sendToPrepare(any(Cart.class));
        then(cartHandler).should(never()).sendToPrepare(any(Cart.class));
        resultCart.getOrders().forEach(tmpOrder -> assertThat(tmpOrder.getOrderStatus(), equalTo(OrderStatus.REJECTED)));
    }

    @Test
    void canHandleCartShouldReturnMultipleValues() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);

        given(cartHandler.canHandleCart(any(Cart.class))).willReturn(true, false, false, true);

        assertThat(cartHandler.canHandleCart(cart), equalTo(true));
        assertThat(cartHandler.canHandleCart(cart), equalTo(false));
        assertThat(cartHandler.canHandleCart(cart), equalTo(false));
        assertThat(cartHandler.canHandleCart(cart), equalTo(true));
    }

    @Test
    void processCartShouldSendToPrepareWithLambdas() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(argThat(c -> c.getOrders().size() > 0))).willReturn(true);

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        then(cartHandler).should().sendToPrepare(cart);
        assertThat(resultCart.getOrders(), hasSize(1));
        resultCart.getOrders().forEach(tmpOrder -> assertThat(tmpOrder.getOrderStatus(), equalTo(OrderStatus.PREPARING)));
    }

    @Test
    void canHandleCartShouldThrowException() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(cart)).willThrow(IllegalStateException.class);

        // when + then
        assertThrows(IllegalStateException.class, () -> cartService.processCart(cart));
    }

    @Test
    void processCartShouldSendToPrepareWithArgumentCaptor() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        /** no needed since @Captor
        ArgumentCaptor<Cart> argumentCaptor = ArgumentCaptor.forClass(Cart.class);
        */
        given(cartHandler.canHandleCart(cart)).willReturn(true);

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        then(cartHandler).should().sendToPrepare(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue().getOrders().size(), equalTo(1));
        assertThat(resultCart.getOrders(), hasSize(1));
        resultCart.getOrders().forEach(tmpOrder -> assertThat(tmpOrder.getOrderStatus(), equalTo(OrderStatus.PREPARING)));
    }

    @Test
    void shouldDoNothingWhenProcessCart() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(cart)).willReturn(true);

        doNothing().when(cartHandler).sendToPrepare(cart);
        willDoNothing().given(cartHandler).sendToPrepare(cart);

        // when we have a second call sendToPrepare w cartService -> it will throw an exception
        willDoNothing().willThrow(IllegalStateException.class).given(cartHandler).sendToPrepare(cart);

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        verify(cartHandler).sendToPrepare(cart);
        verify(cartHandler, times(1)).sendToPrepare(cart);
    }

    @Test
    void shouldAnswerWhenProcessCart() {
        // given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        // here we are able to execute something on the argument passed to our mock --> invocation mock
        doAnswer(invocationOnMock -> {
            Cart argumentCart = invocationOnMock.getArgument(0);
            argumentCart.clearCart();
            return true;
        }).when(cartHandler).canHandleCart(cart);
        when(cartHandler.canHandleCart(cart)).then(invocationOnMock -> {
            Cart argumentCart = invocationOnMock.getArgument(0);
            argumentCart.clearCart();
            return true;
        });

        // BDD
        willAnswer(invocationOnMock -> {
            Cart argumentCart = invocationOnMock.getArgument(0);
            argumentCart.clearCart();
            return true;
        }).given(cartHandler).canHandleCart(cart);
        given(cartHandler.canHandleCart(cart)).will(invocationOnMock -> {
            Cart argumentCart = invocationOnMock.getArgument(0);
            argumentCart.clearCart();
            return true;
        });

        // when
        Cart resultCart = cartService.processCart(cart);

        // then
        assertThat(resultCart.getOrders().size(), equalTo(0));
    }

    @Test
    void deliveryShouldBeFree() {
        // given
        Cart cart = new Cart();
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        CartHandler cartHandler = mock(CartHandler.class);
        //given(cartHandler.isDeliveryFree(cart)).willCallRealMethod(); // BDD
        doCallRealMethod().when(cartHandler).isDeliveryFree(cart);  // classic

        // when
        boolean isDeliveryFree = cartHandler.isDeliveryFree(cart);

        // then
        assertThat(isDeliveryFree, equalTo(true));
    }
}