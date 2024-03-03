理解问题 → 复述(举例) → 澄清(边角) → 初步想法 → 实例分析走一遍 → 整洁写码 → 主动测试 → 解释性能 → 优化
-  初步想法 Logic
   - Speak out bruce force, any workable
   - Get better soln with hints
- 整洁写码 Code Quality
  - Finish major code
  - Readable, clean, structured, meaningful variable names， constant variables
  - 优化 High coupling (spaghetti long running code)
---
- Daily Highlight: https://www.yuque.com/chengxuyuancarl/wnx1np/ktwax2
- 32th Record: https://docs.qq.com/sheet/DUGV1bWJRdW1zaEda?tab=BB08J2
- Daily list: https://docs.qq.com/doc/DUEVRd2RKZEVsdFl3
---
### 算法复杂度，反推算法复杂度
- Array, search O(1),适合写多读少的, 其他O(n);删可O(1)移尾补空
- LinkedList增删O(1),delete需知道前面的node, findO(n)
- Heap: O(1) top; other push/delete/pop O(logn)
- HashTable O(1)/O(L); L as length of key string
- Segment Tree: O(1) min/max/sum; O(logn)增删查改lower/upperBound, rangeMin/Max/Sum
- Binary Indexed Tree: O(logn) rangeSum
- Skip List/RB-Tree: O(1) max/min; O(logn)增删查改lower/upperBound
- Union Find: O(1) Find, union, isConnected, getSize

- O(1) math problems
- O(logn) 90%binary search, 倍增(每次X2）快速幂(x^n),Euclid_gcd
- O(sqrtn) factorization
- O(n): Two Pointers90%; BinaryTreeTraversal/DivideConquer; N*(O(1)[UnionFind/HashMap); Monotonic-stack/queue; Enumeration
- O(nlogn): sorting;binary n * logn
- O(nlogk): k interval
- O(n+m) BFS
- O(n^2),O(n^3) dynamic, BFS if nxn matrix
- O(2^n): combination DFS
- O(n!): permutation DFS

---
- **理解** -- 写 -- **讲** （过程艰难，但结果会美好）
- **有成长的抄答案**，最快的速度爬到前人的肩膀上，是高效的学习方式
- 看答案不是为了混pass题，而是要**理解答案中的思路**，并逐渐累积，形成自己的思维体系
- **反复训练**中的很多伦是在**回复思路**，而不是反复重写
- 能讲和能写一样重要，但在会讲题前，**得先学会写**；会写之前，得**先理解**
- 按市场价格，学会一题，相当于赚500，而且是每年
---
1. 基础知识学习
2. 初刷必背+核心 （30+100），看出题类，总结～100题笔记
3. 精刷必背思路
4. 精刷核心 （能默写必备的答案，理解核心题的思路）
5. 初刷分类重点 (400) 思考 -- 看答案+整理笔记
6. 复刷必背和核心（默写必背+讲题clarify，有思路，核心题有思路且最后能写出
7. 高频顺序精刷重点题，同时回顾必背和核心，注重思路，要点，易错点。～300完整的知识体系笔记
8. 复刷必背，核心题（一次过）+ 回顾重点题
9. 复刷重点题 + 回顾所有做过的题： 对于重点题，也基本看到就有思路
10. 快速回顾所有做过的题，模拟面经（clarify，解法描述，写题跑case等。看不看答案都做笔记
---
1. 必背 ~20-30道，典型模版题，刷十几遍，半昏迷状态也能熟练默写的肌肉记忆状态
2. 核心 ~100-150，高频和经典题，5-8遍以上，需要做到最优解，medium < 10min，hard 15min，无错一遍过，同时要能解释清楚思路，多重解法的优缺点，和tradfeoff的原因 
3. 重点 ～200-300 核心之外的高频题，5遍左右。遇到原题和类似题，基本思路和逻辑不会错，临场也能bug free
4. 普通 1-2遍有思路，临场遇见不慌
---
- 初刷 【半小时内
  - 短时间内5min没有思路不要死缠烂打，早点看答案，找到最优解，并尽力去理解，用自己的代码风格“抄写”，不完全懂也没关系，标注一下，以后再看，每题控制在半小时内
- 精刷 【1小时内
  - 针对初刷过还没充分理解的题，尽量全面理解答案，能默写出来并调试通过。将解题思路和形成的答案加到笔记。用显著符号标识该题，写下困惑的地方，设好reminder，过一段时间再看看
- 过题 【5-10min
  - 按照笔记的标签，比如按照分类或者优先级，大量复习题目。针对做过的题复习。如果对这一题还有印象，大脑中过一遍解题思路和实现中的细节要点；如不记得，进行主动思考寻求解法，之后对比之前的答案和笔记看对不对。如果不对，要强化思考并记忆，不需要写题
- 复刷 【20min内
  - 针对做过的题进行复习。自言自语clarify题意，讲清楚自己的思路，写题，检查，跑case，争取bug free一遍过。只有参考笔记和标准答案来复盘自己的错误和不足。
- 模拟 【30min内
  - 抽取一道新题，看能不能做过复刷的效果目标。把题记入笔记。
---
## LC: DMSXL -- Neetcode -- 剑指 -- Log -- 古城 -- Blind 75 -- 公司tag

## Sys-design: Alex I -- Alex II -- Youtube -- 古城 -- 九章（网盘

## Design patter: 随想录 -- 九章 -- 古城

## OOD & Concepts: Java, C++ -- SQL -- Shell
---
- Format instructions: https://docs.qq.com/doc/DUEdmb1JCaEtlZWFx
- 30 Log: https://docs.qq.com/sheet/DUFVFaFZEa0J2UnJk
---
