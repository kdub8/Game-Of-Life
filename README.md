# Game-Of-Life

This program is one that implements Conway's Game of Life. Life can be portrayed as a simulation
where one-celled organisms lie on a 2D board of square cells. Organisms that are alive are represented
by 1s, and dead organisms are represented by 0s. To compute which cells die and live, there are rules that must be followed
per iteration of the board. Depending on the number of surrounding neighboring cells, the cell will either stay alive,
come to life, or die in the next generation. The user is asked to input a file name and the data from that file is then imported
into a 2D array. The rows and columns are scanned and used to create the dimensions of the 2D array. A recursive method
called computeNextGeneration is used to iterate through multiple generations of the organisms on the board. For loops 
and if statements see if the neighboring cells are 1s or 0s. The getCell method gets a value so that it can determine what 
value it should be set to. The generation integer is decremented until there are no more generations to calculate. The print 
method then prints the whole board out to the console.
