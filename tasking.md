1.Given 还有空位的存储柜, When 用户寄存一件货物, Then 成功存取并返回唯一的票据.

2.Given 没有空位的存储柜, When 用户寄存一件货物, Then 不能成功存取.



3.Given 没有使用过的票据, When 用户取件, Then 成功取走票据对应的货物.

4.Given 使用过的票据, When 用户重复取件, Then 提示货物已被取走.

5.Given 错误的票据, When 用户取件, Then 提示票据错误.

6.Given 只有一个空位的存储柜，When 用户存2件货物，Then第一件存成功

7.Given 没有空位的存储柜，When 用户取1件货物然后存一件货物，Then返回票据


1.Given 还有空位的Robot(2*储物柜*n), When 用户寄存一件货物, Then 成功存取并返回唯一的票据.

2.Given 没有空位的Robot(2*储物柜*0), When 用户寄存一件货物, Then 不能成功存取.

2.1.Given 还有空位的Robot(储物柜*0+储物柜*n), When 用户寄存一件货物, Then 成功存取并返回唯一的票据.

3.Given 没有使用过的票据, When 用户取件, Then 成功取走票据对应的货物.

4.Given 使用过的票据, When 用户重复取件, Then 提示货物已被取走.

5.Given 错误的票据, When 用户取件, Then 提示票据错误.

6.Given 有空位的Robot(储物柜*1+储物柜*n)，When 用户取1件在1号柜的货物然后存，Then成功存在1号柜.

7.Given 有空位的Robot(储物柜*0+储物柜*n)，When 用用户存货物，Then成功存并返回唯一的票据.

//2020.4.9
1.Given 还有空位的Robot(2*储物柜*n), When 用户寄存一件货物, Then 成功存取并返回唯一的票据.

2.Given 没有空位的Robot(2*储物柜*0), When 用户寄存一件货物, Then 不能成功存取.

2.1.Given 还有空位的Robot(储物柜*0+储物柜*n), When 用户寄存一件货物, Then 成功存取并返回唯一的票据.
2.2.Given 还有空位的Robot(储物柜*1+储物柜*2), When 用户寄存一件货物, Then 成功存在2号柜.

3.Given 没有使用过的票据, When 用户取件, Then 成功取走票据对应的货物.

4.Given 使用过的票据, When 用户重复取件, Then 不能取出货物.

5.Given 错误的票据, When 用户取件, Then 提示票据错误.