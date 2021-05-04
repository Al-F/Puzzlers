package leetCode.april2021

class PowerfulIntegers {
    fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        val result = HashSet<Int>()
        var powx = HashSet<Double>()
        val powy = HashSet<Double>()
        var curx = 0.0
        var i = 0
        while (curx<bound){
            curx = Math.pow(x.toDouble(), i.toDouble())
            if (powx.contains(curx)){
                break
            }
            powx.add(curx)
            i++
        }
        var cury = 0.0
        i = 0
        while (cury<bound){
            cury = Math.pow(y.toDouble(), i.toDouble())
            if (powy.contains(cury)){
                break
            }
            powy.add(cury)
            i++
        }
        for (i in powx){
            for (j in powy){
                if (i+j<=bound) result.add(i.toInt()+j.toInt())
            }
        }
        return result.toList()
    }
}