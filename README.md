# overload-demo

A demo of https://clojars.org/overload-middleware.

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

http://localhost:3000/wrapped has overload control; /unwrapped
doesn't. I tested with Apache Bench (ab) using the parameters ab -n 50000 -c 300.

## License

Copyright © 2013 Robert K. Day
