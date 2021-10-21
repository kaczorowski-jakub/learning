package misc;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MyStream implements Stream<MyStream>{

    @Override
    public Iterator<MyStream> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Spliterator<MyStream> spliterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isParallel() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Stream<MyStream> sequential() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> parallel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> unordered() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> onClose(Runnable closeHandler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Stream<MyStream> filter(Predicate<? super MyStream> predicate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <R> Stream<R> map(Function<? super MyStream, ? extends R> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super MyStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super MyStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super MyStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <R> Stream<R> flatMap(Function<? super MyStream, ? extends Stream<? extends R>> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IntStream flatMapToInt(Function<? super MyStream, ? extends IntStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LongStream flatMapToLong(Function<? super MyStream, ? extends LongStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super MyStream, ? extends DoubleStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> distinct() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> sorted() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> sorted(Comparator<? super MyStream> comparator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> peek(Consumer<? super MyStream> action) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> limit(long maxSize) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<MyStream> skip(long n) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void forEach(Consumer<? super MyStream> action) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void forEachOrdered(Consumer<? super MyStream> action) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MyStream reduce(MyStream identity, BinaryOperator<MyStream> accumulator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<MyStream> reduce(BinaryOperator<MyStream> accumulator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super MyStream, U> accumulator, BinaryOperator<U> combiner) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super MyStream> accumulator, BiConsumer<R, R> combiner) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <R, A> R collect(Collector<? super MyStream, A, R> collector) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<MyStream> min(Comparator<? super MyStream> comparator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<MyStream> max(Comparator<? super MyStream> comparator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean anyMatch(Predicate<? super MyStream> predicate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super MyStream> predicate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean noneMatch(Predicate<? super MyStream> predicate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<MyStream> findFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<MyStream> findAny() {
        // TODO Auto-generated method stub
        return null;
    }

}
