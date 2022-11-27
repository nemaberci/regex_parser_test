# Tests of generated regular expression parser

### The regular expression parser is available [here](https://github.com/nemaberci/regex_parser_generator)

This project includes tests and benchmarks for a regular expression parser generator. The generator
is an annotation processor, so it is difficult to test it in the same project. Because we want to
test the results of the generated code and because there are few good frameworks that can be used to
test generated code, we test it externally, in this project.

The main class contains a benchmark used to test the results and speed of the generated code.