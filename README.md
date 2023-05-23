<h1 style="font-weight: bold; color: #334;">Order Processing Application</h1>

<p>
The Order Processing Application is a Java based application that reads orders from a CSV file, splits them by country, and performs processing and provides persistence operations. It utilizes abstractions, interfaces, and various Java APIs features to ensure performance, scalability, and adherence to SOLID principles.
</p>

<h2>Getting Started</h2>
To get started with the application, follow the instructions below.

<h2>Prerequisites</h2>
Java Development Kit (JDK) 8 or higher
CSV file containing orders (e.g., orders.csv)

<h2>Installation</h2>
Clone the repository or download the source code files.

Ensure that you have Java Development Kit (JDK) installed on your machine.

<h2>Usage</h2>
Open a terminal or command prompt.

Navigate to the directory where the application files are located.

Compile the source code files using the following command: javac *.java
Run the application using the following command: java Main

<p>
The application will start processing the orders from the provided CSV file.

Processing information and status updates have been logged into console as of now.

After processing, the orders will be persisted based on the implemented persistence logic.

Abstractions and Interfaces
The application emphasizes the use of abstractions and interfaces to promote modularity and scalability. The key abstractions and interfaces used in the application are:

DataReader: An interface that defines the functionality for reading data from a file. The CSVDataReaderImpl class implements this interface to handle reading orders from a CSV data file.

DataProcessor: An interface that represents the functionality for processing and persisting orders. The OrderDataProcessorImpl class implements this interface, performing the processing and persistence operations.

Performance Considerations
To enhance performance, the application utilizes the following:

Fork/Join Pool: The application utilizes the ForkJoinPool to process orders in parallel. This allows for efficient utilization of available resources and improved performance when dealing with large datasets.

Java 8 Stream API: The application leverages the Stream API provided by Java 8 for efficient and concise processing of data. Streams provide parallel execution capabilities, enabling efficient operations on large collections of orders.

SOLID Principles
The application follows the SOLID principles of object-oriented design:

Single Responsibility Principle (SRP): Each class has a single responsibility, ensuring that it has only one reason to change.

Open/Closed Principle (OCP): The code is designed to be open for extension but closed for modification. New functionalities can be added by introducing new classes or interfaces without modifying the existing code.

Liskov Substitution Principle (LSP): The application adheres to LSP, ensuring that objects of the same interface can be used interchangeably without affecting the correctness of the program.

Interface Segregation Principle (ISP): The application follows ISP by providing separate interfaces for different responsibilities (e.g., DataReader and DataProcessor).

Dependency Inversion Principle (DIP): Dependencies in the application are inverted by relying on abstractions (interfaces) instead of concrete implementations, promoting loose coupling and easier maintenance.
</p>

<h2>Contributing</h2>
Contributions to the Order Processing Application are welcome! If you have any ideas, suggestions, or improvements, please feel free to submit a pull request or open an issue.

<h2>License</h2>
This project is licensed under the <a href="https://opensource.org/licenses/MIT">MIT License</a>.

<h2>Acknowledgements</h2>
<a href="https://docs.oracle.com/en/java/">Java Documentation</a> - Official Java documentation for reference.</br>

<a href="https://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html">Fork/Join Framework</a> - Oracle's tutorial on the Fork/Join framework in Java.

<a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html">Java Stream API</a> - Java documentation for the Stream API.

<a href="https://en.wikipedia.org/wiki/SOLID">SOLID Principles</a> - Wikipedia article explaining the SOLID principles of object-oriented design.

Feel free to customize this README file according to your specific application and project structure.
