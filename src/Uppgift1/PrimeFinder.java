package Uppgift1;

import java.util.concurrent.Callable;

public class PrimeFinder implements Callable<Long> {
    private long primesFound = 0;
    private final long numbersToSearch;
    private final long skipLength;
    private final long startPoint;

    public PrimeFinder(long numbersToSearch, long skipLength, long startPoint){
        this.numbersToSearch = numbersToSearch;
        this.skipLength = skipLength;
        this.startPoint = startPoint;
    }

    private void findPrimes() {
        boolean isDividable = false;
        for(long number = startPoint; number<=numbersToSearch; number+=skipLength) {
            for (long d = 2; d <= Math.sqrt(number); d++) {
                if (number % d == 0)
                    isDividable = true;
            }
            if(!isDividable)
                primesFound++;
            isDividable = false;
        }
    }

    public Long call(){
        findPrimes();
        return primesFound;
    }

}
