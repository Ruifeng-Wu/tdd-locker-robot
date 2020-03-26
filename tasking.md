1.Given 还有空位的存储柜, When 用户寄存一件货物, Then 成功存取并返回唯一的票据.
given when should
2.Given 没有空位的存储柜, When 用户寄存一件货物, Then 不能成功存取.



3.Given 没有使用过的票据, When 用户取件, Then 成功取走票据对应的货物.

4.Given 使用过的票据, When 用户重复取件, Then 提示货物已被取走.

5.Given 错误的票据, When 用户取件, Then 提示票据错误.
