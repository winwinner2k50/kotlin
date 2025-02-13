import java.util.Random

class place (var i: Int, var j: Int)
{
    var color: String =  " "
    init
    {
       
    }
}

class pole(val n: Int, val m: Int)
{
    
    val a = Array(n) {Array(m) {place(-1, -1)}}
    init
    {
        for (i in n - 1 downTo 0)
        {
            for (j in 0 until m)
            {
                a[i][j].i = i
                a[i][j].j = j
                gen_color(i, j)
                println("$i $j")
            }
            
            output()
            
            //println("\u001b[H\u001b[2J")
        }
    }

    fun gen_color(pos1: Int, pos2: Int)
    {
        var color_try = ""
        do
        {
            val r =  Random().nextInt(4) 
            if (r == 0)
                color_try = "@"
            if (r == 1)
                color_try= "#"
            if (r == 2)
                color_try = "&"
            if (r == 3)
                color_try = "$"
        }
        while (!check_color(pos1, pos2, color_try))
        a[pos1][pos2].color = color_try
        
    }

    fun check_color(i: Int, j: Int, color: String): Boolean
    {
        var down: Boolean
        var left: Boolean
        var right: Boolean
        var up: Boolean
        if (j > 1)
            left = a[i][j - 1].color != color || a[i][j - 2].color != color
        else
            left = true
        if (m - j > 2)
            right = a[i][j + 1].color != color || a[i][j + 2].color != color
        else
            right = true
        if (n - i > 2)
            down = a[i + 1][j].color != color || a[i + 2][j].color != color
        else
            down = true
        if (i > 1)
            up = a[i - 1][j].color != color || a[i - 2][j].color != color
        else
            up = true
        return down && up && left && right
    }

    fun output()
    {
        println("\u001b[H\u001b[2J")
        print("  ")
        for (i in 0 until m)
        {
            print(i+1)
        }
        print("\n")
        for (i in 0 until m + 3)
        {
            print("-")
        }
        print("\n")
        for (i in 0 until n)
        {
            print("${i+1}|")
            for (j in 0 until m)
            {
                print(a[i][j].color)
            }
            println("|")
        }
        for (i in 0 until m + 3)
        {
            print("-")
        }
        print("\n")
        Thread.sleep(1200)
    }

    fun check_all_place(): Boolean
    {
        var ok: Boolean = false
        for (i in 0 until n)
        {
            for (j in 0 until m)
            {
                if(a[i][j].color != " " && (!check_color(i, j, a[i][j].color)))
                {
                    dell_el(i, j)
                    ok = true
                }     
            }
        }
        println("ok4")
        return ok
    }

    fun swap_dell():Boolean
    {
        var ok: Boolean = false
        for (i in 0 until n)
        {
            for (j in 0 until m)
            {
                if (a[i][j].color == " ")
                {
                    ok = true
                    if (i != 0)
                    {
                        swap(i, j, i - 1, j)
                        println("ok")
                    }     
                    else
                    {
                        val r =  Random().nextInt(4) 
                        if (r == 0)
                            a[i][j].color = "@"
                        if (r == 1)
                            a[i][j].color= "#"
                        if (r == 2)
                            a[i][j].color = "&"
                        if (r == 3)
                            a[i][j].color = "$"
                    }
                }     
            }
        }
        println("ok3")
        return ok
    }

    fun dell_el(pos_i: Int, pos_j: Int)
    {
        val color_start = a[pos_i][pos_j].color
        if (pos_j > 1)
        {
            if (a[pos_i][pos_j - 1].color == color_start && a[pos_i][pos_j - 2].color == color_start)
            {
                for (j in pos_j - 1 downTo 0)
                {
                    if (a[pos_i][j].color == color_start)
                        a[pos_i][j].color = " "
                    else
                        break 
                }
            }
           
        }
        if (m - pos_j > 2)
        {
            if (a[pos_i][pos_j + 1].color == color_start && a[pos_i][pos_j + 2].color == color_start)
            {
                for (j in pos_j + 1 until m)
                {
                    if (a[pos_i][j].color == color_start)
                        a[pos_i][j].color = " "
                    else
                        break 
                } 
            }
           
        }
        if (n - pos_i > 2)
        {
            if (a[pos_i + 1][pos_j].color == color_start && a[pos_i + 2][pos_j].color == color_start)
            {
                for (i in pos_i + 1 until n)
                {
                    if (a[i][pos_j].color == color_start)
                        a[i][pos_j].color = " "
                    else
                        break 
                }
            }
            
        }
        if (pos_i > 1)
        {
            if (a[pos_i - 1][pos_j].color == color_start && a[pos_i - 2][pos_j].color == color_start)
            {
                for (i in pos_i - 1 downTo 0)
                {
                    if (a[i][pos_j].color == color_start)
                        a[i][pos_j].color = " "
                    else
                        break 
                } 
            }
            
        }
        a[pos_i][pos_j].color = " "
    }

    fun swap(i1: Int, j1: Int, i2: Int, j2: Int)
    {
        val color_helper = a[i1][j1].color
        a[i1][j1].color = a[i2][j2].color
        a[i2][j2].color = color_helper
    }

}

fun main()
{
    val a = pole(5, 5)
    while (true)
    {
        var (i1, j1) = readLine()!!.split(" ").map { it.toInt() }
        var (i2, j2) = readLine()!!.split(" ").map { it.toInt() }
        i1--;
        j1--;
        i2--;
        j2--;
        a.swap(i1, j1, i2, j2)
        a.output()
        var ok: Boolean = false
        do
        {
            ok = false
            while(a.swap_dell())
            {
                a.output()
            }
            while(a.check_all_place())
            {
                ok = true
                a.output()
            }
        }while(ok)

        a.output()
    }
}