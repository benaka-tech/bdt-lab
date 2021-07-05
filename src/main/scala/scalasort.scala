object scalasort {

  def sort(a: List[Int]): List[Int] = {
    if (a.length < 2) a
    else {
      val pivot = a(a.length / 2)
      sort(a.filter(_ < pivot)) :::
      a.filter(_ == pivot) :::
      sort(a.filter(_ > pivot))
    }
  }

  def sort1(a:Array[Int])  {
  
  	def swap ( l:Int,r:Int) {
  		val t = a(l) ; a(l) = a (r) ; a(r) = t
  		}
  		
  	def sort2(l:Int, r:Int) {
  		val pivot = a((l+r)/2)
		var i =l
		var j = r
		while (i <= j) {
			while (a(i) < pivot ) i += 1
			while (a(j) > pivot) j -= 1
			if (i <= j) {
				swap (i,j)
				i += 1
				j -= 1
				}
			}
			if (l< j) sort2(l,j)
			if (j < r) sort2(i,r)
		}
	if (a.length > 0)
		sort2(0,a.length-1)
}

  def main(args: Array[String]) {

    val xs = List(6, 2, 8, 5, 1)
    println(xs)
    println("Sorted List using the functional style")
    println(sort(xs))

    val xs2 = Array(61,21,81,51,11)
    sort1(xs2)
    println("Sorted array using Imperative method")
	for (ele <- xs2)
		println(ele)

  }
}
