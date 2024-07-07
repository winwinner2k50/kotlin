fun main() 
{
    println("Введите размерность матрицы (строки и столбцы, через пробел):")
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val a = Array(n) { IntArray(m) }
    println("Введите элементы матрицы:")
    
    matrix_input(a, n, m)

    // Вызов функции для изменения матрицы
    matrix_sort(a, n, m)

    println("Новая матрица")
    matrix_output(a)
}

fun matrix_input(a: Array<IntArray>, n: Int, m: Int)
{
    for (i in 0 until n) 
    {
        val rowInput = readLine()!!.split(" ")
        for (j in 0 until m) 
        {
            a[i][j] = rowInput[j].toInt()
        }
    }
}

fun matrix_output(a: Array<IntArray>)
{
    for (row in a) 
    {
        println(row.joinToString(" "))
    }
}

fun matrix_sort(a: Array<IntArray>, n: Int, m: Int)
{
    val sum_str = Array(n) {0}

    for (i in 0 until n)
    {
        for (j in 0 until m)
        {
            sum_str[i] += a[i][j]
        }
    }

    for (i in 1 until n)
    {
        for (j in 0 until (n - i))
        {
            if (sum_str[j] > sum_str[j + 1])
            {
                matrix_str_swap(a, j, j + 1)
                arr_swap(sum_str, j, j + 1)
            }
        }
    }
}

fun arr_swap(a: Array<Int>, pos1: Int, pos2: Int)
{
    val helper = a[pos1]
    a[pos1] = a[pos2]
    a[pos2] = helper 
}

fun matrix_str_swap(a: Array<IntArray>, pos1: Int, pos2: Int)
{
    val helper = a[pos1]
    a[pos1] = a[pos2]
    a[pos2] = helper 
}