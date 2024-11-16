import kotlin.system.exitProcess

fun main() {
    val pizzaPeter = PizzaPeter(
        neapolitanPizzaPrice: 175.0, romanPizzaPrice: 241.5,
    sicilianPizzaPrice: 167.5, tyroleanPizzaPrice: 215.0
    )
    val pizzaMoscow = PizzaMoscow(
        neapolitanPizzaPrice: 215.0, romanPizzaPrice: 250.5,
    sicilianPizzaPrice: 180.5, tyroleanPizzaPrice: 240.0
    )
    val currentPizzaCity: PizzaCity

    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n\n0. Выход из программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }
        println("Выберите пиццу:")
        println(
            "1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n" +
                    "4. Тирольская пицца\n\n0. Показать статистику"
        )
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
        when (readln()) {
            "1" -> {
                currentPizzaCity.neapolitanPizzaSale()
                selectAddService(currentPizzaCity)
            }
            "2" -> {
                currentPizzaCity.romanPizzaSale()
                selectAddService(currentPizzaCity)
            }
            "3" -> {
                currentPizzaCity.sicilianPizzaSale()
                selectAddService(currentPizzaCity)
            }
            "4" -> {
                currentPizzaCity.tyroleanPizzaSale()
                selectAddService(currentPizzaCity)
            }
            "0" -> currentPizzaCity.showStatistics()
            else -> {
                println("ERROR")
                exitProcess(1)
            }
        }
    }

        fun selectAddService(currentPizzaCity: PizzaCity) {
        when (currentPizzaCity) {
            is CheckPhoto -> currentPizzaCity.showCheckPhoto()
            else -> currentPizzaCity.drinkSale()
        }
    }
