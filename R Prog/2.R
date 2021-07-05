vtr=c(rep("control",3),rep("Ear removal",4),rep("fake ear removal",3))
vtr
xfact=factor(vtr)
xfact

nlevels(xfact)

xin=c(rep("a",25),rep("b",15),rep("c",58))
xin

length(xin)
table(xin)
