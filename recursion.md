# recursion: 递归次数 * 每次递归中的操作次数
#### y = x ^ n
    // 递归n次，每次O(1)
    function1N (int x, int n) { 
        int result = 1; // x^0 = 1
        for ( int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }

    // 递归n次，每次O(1)
    function2N (int x, int n) {
        if (n == 0) return 1;
        return x * function2N(x, n - 1);
    }

    // 2^0 + 2^1 +...+2^m = 2^(m+1) = 2^(log2^n -1 + 1) -1 = O(n)
    // Full tree each node is a multiply, there're n nodes
    function3N (int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 1) return function3N (int x, int n/2) * function3N (int x, int n/2) * x; // n奇数/2会减1
        return function3N (int x, int n/2) * function3N (int x, int n/2)
    }
    /*
                                    16
                        8                        8
                4           4               4            4
            2      2     2      2        2      2     2      2
        1     1  1  1  1   1  1   1   1   1  1   1  1   1  1   1
    */

    // 递归 log n次，每次O(1)
    function4LogN (int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        int t = function4LogN(x , n/2);
        if (n % 2 == 1) return t * t * x;
        return t * t;
    }