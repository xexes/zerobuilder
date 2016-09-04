The builder pattern improves readability by making parameter names visible.

In many implementations of the builder pattern, 
such as those generated by [auto-value](https://github.com/google/auto/tree/master/value)
it is possible to specify a parameter twice, or forget a required parameter.

To guard against this, we could write a chain of interfaces, each representing one parameter.
This repetitive work is best left to a code generator.

Under the hood, a single mutable object can implement all of these &quot;step&quot; interfaces. 
Because parameters cannot be forgotten anymore, it is safe to reuse this object by storing it in a `ThreadLocal`.
