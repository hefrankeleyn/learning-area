package com.hef.algorithms.fundamentals.analysis_of_algorithms.exercise1_4.exe01;

/**
 * Show that the number of different triples that can be chosen from N items is precisely N (N-1) (N-2)/6.
 * Hint: Use mathematical induction or a counting argument
 * @Date 2019-05-23
 * @Author lifei
 */
public class ShowTriples {
    // https://www.chegg.com/homework-help/algorithms-4th-edition-chapter-1.4-solutions-9780321573513
    // step 1:
    /*
    // Mathematical induction: is proofing technique, which involve two steps.
    1. Base step: Prove it for the first number say 0 or 1;
    2. Inductive step: Assuma that is true for any number and then prove it is true for the immediately next number
     */

    // Step 2:  Base step
    /*
    It is clear that the least number of which triples of can be chosen are 3. Science they have to be different.
    Now, for N=3, the number of different triples that can be chosen from 3 items is precisely 1 as they are the only 3 different numbers.
    Using the formula:
    N(N-1)(N-2)/6       = 3 * (3-1) * (3-2) /6 = 3*2*1/6 = 1

    Now, for N=4, the number of different triples that can be chosen from 4 items would be 4. Again using the formula also. It is:
    N(N-1)(N-2)/6       = 4 * (4-1) * (4-2) /6 = 4 * 3 * 2 / 6 = 4

     */

    // Step 3: Inductive step
    /*
    Now, let us assume that it is true for N. This means N(N-1)(N-2)/6 is true for N.
    To prove it n+1. Substitute N+1 in above formula so that it has to be proved that number of different triples that can be chosen
    from N+1 items is given us:
    (N+1)(N+1-1)(N+1-2)/6 = (N+1)N(N-1)/6

    Now, the number of different triples that can be chosen from n+1 is also given as sum of number of different triples
    that can be chosen from N items and the number of ways to choose 2 element from a set of N element
    =N(N-1)(N-2)/6 + C(N,2) = N(N-1)(N-2)/6 + N(N-1)/2 = (N+1)N(N-1)/6
     */


}
