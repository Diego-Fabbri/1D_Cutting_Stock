\ENCODING=ISO-8859-1
\Problem name: ilog.cplex

Minimize
 obj: x(1)#0 + x(2)#1 + x(3)#2 + x(4)#3 + x(5)#4 + x(6)#5 + x(7)#6 + x(8)#7
      + x(9)#8 + x(10)#9 + x(11)#10 + x(12)#11 + x(13)#12 + x(14)#13 + x(15)#14
      + x(16)#15 + x(17)#16 + x(18)#17 + x(19)#18 + x(20)#19
Subject To
 c1: x(1)#0 + x(4)#3 + x(5)#4 + x(11)#10 + x(15)#14 + 2 x(19)#18 >= 50
 c3: x(1)#0 + 2 x(3)#2 + x(7)#6 + x(8)#7 + x(12)#11 + x(16)#15 >= 30
 c5: 2 x(2)#1 + x(4)#3 + x(7)#6 + x(9)#8 + 2 x(10)#9 + x(13)#12 + x(17)#16
     >= 40
 c7: x(2)#1 + 2 x(5)#4 + 2 x(8)#7 + 2 x(9)#8 + x(11)#10 + x(12)#11 + x(13)#12
     + 3 x(14)#13 + 2 x(18)#17 + x(20)#19 >= 42
 c9: x(1)#0 + x(3)#2 + x(4)#3 + 4 x(6)#5 + x(7)#6 + x(10)#9 + x(11)#10
     + x(12)#11 + x(13)#12 + 2 x(15)#14 + 2 x(16)#15 + 2 x(17)#16 + x(18)#17
     + 2 x(20)#19 >= 20
Bounds
 0 <= x(1)#0 <= 2147483647
 0 <= x(2)#1 <= 2147483647
 0 <= x(3)#2 <= 2147483647
 0 <= x(4)#3 <= 2147483647
 0 <= x(5)#4 <= 2147483647
 0 <= x(6)#5 <= 2147483647
 0 <= x(7)#6 <= 2147483647
 0 <= x(8)#7 <= 2147483647
 0 <= x(9)#8 <= 2147483647
 0 <= x(10)#9 <= 2147483647
 0 <= x(11)#10 <= 2147483647
 0 <= x(12)#11 <= 2147483647
 0 <= x(13)#12 <= 2147483647
 0 <= x(14)#13 <= 2147483647
 0 <= x(15)#14 <= 2147483647
 0 <= x(16)#15 <= 2147483647
 0 <= x(17)#16 <= 2147483647
 0 <= x(18)#17 <= 2147483647
 0 <= x(19)#18 <= 2147483647
 0 <= x(20)#19 <= 2147483647
Generals
 x(1)#0  x(2)#1  x(3)#2  x(4)#3  x(5)#4  x(6)#5  x(7)#6  x(8)#7  x(9)#8 
 x(10)#9  x(11)#10  x(12)#11  x(13)#12  x(14)#13  x(15)#14  x(16)#15  x(17)#16 
 x(18)#17  x(19)#18  x(20)#19 
End
