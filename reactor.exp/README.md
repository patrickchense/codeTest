Reactor Exp

https://medium.com/wolox-driving-innovation/reactor-java-meets-reactive-programming-16105c026fc3

Advantages
We can answer many requests or call messages by generating one or a several threads.
It’s possible to do a callback asynchronously and this could potentially save us calling resources.
It achieves weak coupled programming and tends to isolate faults or errors, so it’s easily scalable, and you can anticipate the number of events it can receive.
With the efficient use of resources, we are doing much more with less. Specifically, we can process higher workloads with fewer threads.
Drawbacks
More intensive memory usage is needed to store large data-flows as they are maintained for a long time.
It may be a little different from conventional programming, and it may be hard to understand in the beginning.
Most of the complexities must be dealt with at the time of declaring the service.
It doesn’t work well for applications that have very little data flow, as it can deem simple programming unnecessarily complex, or possibly even affect the performance.
