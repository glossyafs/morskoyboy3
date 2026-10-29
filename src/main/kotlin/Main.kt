    fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===   === Поле игрока ${enemy.name} ===")
    print("  ")
    for (c in 0..9) print("$c ")
    print("     ")
    print("  ")
    for (c in 0..9) print("$c ")
    println()
    for (r in 0..9) {
        print("$r ")
        for (c in 0..9) print("${player.field()[r][c]} ")
        print("     ")
        print("$r ")
        for (c in 0..9) print("${enemy.field()[r][c]} ")
        println()
    }
}
    fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))

    // 1
    val player = Player("Вы")
    val enemy = Player("Компьютер")

    // 2
    player.placeShip(3, 2)
    player.placeShip(3, 3)
    player.placeShip(3, 4)
    player.placeShip(3, 5)

    enemy.placeShip(5, 7)
    enemy.placeShip(6, 7)
    enemy.placeShip(7, 7)

    printBothFields(player, enemy)
    println()

    // 3
    player.registerShot(true)
    player.registerShot(false)
    player.registerShot(true)

    // 4
    println(player.status())
    println("Выстрелов: ${player.shots}")
    println("Попаданий: ${player.hits}")
    player.reset()
    println(player.status())

    // 6
    player.markShot(3, 3, true)
    player.markShot(4, 4, false)
    printBothFields(player, enemy)

    // 5. Закомментированные строки, которые не должны компилироваться
    // player.shots = 100        // Ошибка: val не изменяемое
    // player.hits = -5          // Ошибка: val не изменяемое
    // player.field()[3][2] = '#' // Ошибка: val не изменяемое (ссылка на массив)
    // player.name = "Другой"    // Ошибка: val не изменяемое
}