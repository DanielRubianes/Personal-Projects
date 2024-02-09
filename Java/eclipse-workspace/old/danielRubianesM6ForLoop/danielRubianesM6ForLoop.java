/*
 * Daniel Rubianes
 * Date: 11/2/2018
 * Hendersonville High School
 * For loops
 * 
 * Description: A basic demonstration of for loops
 * Difficulties: None
 * What I learned: Nothing new
*/
public class danielRubianesM6ForLoop
{
    public static void main(String args[])
    {
    	// (first video)
    	// initialize sum variable
        int sum = 0;
        for(int j = 3; j <= 79; j++) {
        	// add j to sum
        	sum += j;
        	// print sum
        	System.out.println(sum);
        }
        System.out.println(sum);
        
        
        // (second video)
        for(int j = 100; j >= 0; j--) {
        	// print j
        	System.out.println(j);
        }
    }
}

/*
 * Sample Output: 
3
7
12
18
25
33
42
52
63
75
88
102
117
133
150
168
187
207
228
250
273
297
322
348
375
403
432
462
493
525
558
592
627
663
700
738
777
817
858
900
943
987
1032
1078
1125
1173
1222
1272
1323
1375
1428
1482
1537
1593
1650
1708
1767
1827
1888
1950
2013
2077
2142
2208
2275
2343
2412
2482
2553
2625
2698
2772
2847
2923
3000
3078
3157
3157
100
99
98
97
96
95
94
93
92
91
90
89
88
87
86
85
84
83
82
81
80
79
78
77
76
75
74
73
72
71
70
69
68
67
66
65
64
63
62
61
60
59
58
57
56
55
54
53
52
51
50
49
48
47
46
45
44
43
42
41
40
39
38
37
36
35
34
33
32
31
30
29
28
27
26
25
24
23
22
21
20
19
18
17
16
15
14
13
12
11
10
9
8
7
6
5
4
3
2
1
0
 */