data()
head(mtcars)


rownum <- nrow(mtcars)
colnum <- ncol(mtcars)

x<- data.frame(mtcars)
automatic <-0
manual <-0

for (i in 1:rownum)
ifelse( x[i,9] == 1, automatic <- automatic + 1, manual <- manual +1)
ifelse (automatic > manual,
print("There are more automatic transmission type"),
print("There are more manual transmission type") )

HorsePower <- x[,4]
Weight <- x[,6]
scatter.smooth(HorsePower,Weight, span=2/3, degree = 1, family =c("symmetric","gaussian"))

Mpg <- x[,1]
hist(Mpg, breaks = 12, col ="lightblue", border = "pink")

x[,2]<- as.integer(x[,2])
x[,8]<- as.integer(x[,8])
x[,9]<- as.integer(x[,9])
x[,2] <= 5
mtcars[mtcars$cyl] <=5 

