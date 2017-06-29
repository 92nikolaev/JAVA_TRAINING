#  TASK 4. MULTITHREADING

Need to create a multithreaded application that works correctly with shared resources and avoids mutual locking situations. Any entity that wants to access the shared resource must be a thread. The application should implement the functionality defined by the individual task.


The railway platform. On the railway platform (right and left), two trains running along different routes can stop at the same time. The time of each train is individual. If the platform is busy, then the train arrives waiting for its turn. The train's passenger can get off on this platform and change to another train if the parking time of this train allows him to do it. On the platform, the passenger can not stay.