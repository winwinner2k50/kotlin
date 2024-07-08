import java.util.Random

class place (var i: Int, var j: Int)
{
    var color: String =  " "
    init
    {
        println("Created at ($i, $j)")
    }
}

class pole(val n: Int, val m: Int)
{
    
    val a = Array(n) {Array(m) {place(-1, -1)}}
    init
    {
        for (i in 0 until n)
        {
            for (j in 0 until m)
            {
                a[i][j].i = i
                a[i][j].j = j
                gen_color(i, j)
            }
            println("\u001b[H\u001b[2J")
            output()
            Thread.sleep(1500)
            println("\u001b[H\u001b[2J")
        }
    }

    fun gen_color(pos1: Int, pos2: Int)
    {
        val r =  Random().nextInt(4) 
        if (r == 0)
            a[pos1][pos2].color = "@"
        if (r == 1)
            a[pos1][pos2].color = "#"
        if (r == 2)
            a[pos1][pos2].color = "&"
        if (r == 3)
            a[pos1][pos2].color = "$"
    }

    fun output()
    {
        for (i in 0 until n)
        {
            print("|")
            for (j in 0 until m)
            {
                print(a[i][j].color)
            }
            println("|")
        }
    }

}

fun main()
{
    val a = pole(3, 3)
}