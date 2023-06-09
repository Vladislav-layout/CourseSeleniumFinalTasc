# language: ru
@all
Функционал: Поиск

  @Test
  Сценарий: Проверка поиска на отображение искомого продукта №1
    * Проверка открытия страницы по title = "Регард - интернет магазин компьютеров и комплектующих, техники для офиса и электроники. Сборка ПК. Доставка по России"
    * Открыть меню 'Каталог'
    * Выбор пункта "Комплектующие для ПК" из каталога
    * Проверка открытия страницы выбранной категории по хлебным крошкам
    * Выбор карточки "Видеокарты" из подкаталога
    * Проверка открытия страницы выбранной подкатегории по хлебным крошкам
    * Установка в поле "Минимальная цена" значения "20000"
    * Клик по чекбосу с текстом "Gigabyte"
    * Проверка, что в поисковой выдаче не больше 24 товаров
    * Ввести в поисковую строку запомненное наименование первого товара из предыдущего шага
    * Проверка, что в поисковой выдаче не больше 1 товаров
    * Проверить, что наименование товара соответствует сохраненному значению


  @Test
  Сценарий: Проверка поиска на отображение искомого продукта №2
    * Проверка открытия страницы по title = "Регард - интернет магазин компьютеров и комплектующих, техники для офиса и электроники. Сборка ПК. Доставка по России"
    * Открыть меню 'Каталог'
    * Выбор пункта "Периферия" из каталога
    * Проверка открытия страницы выбранной категории по хлебным крошкам
    * Выбор карточки "Клавиатуры" из подкаталога
    * Проверка открытия страницы выбранной подкатегории по хлебным крошкам
    * Установка в поле "Минимальная цена" значения "2000"
    * Клик по чекбосу с текстом "A4Tech"
    * Проверка, что в поисковой выдаче не больше 24 товаров
    * Ввести в поисковую строку запомненное наименование первого товара из предыдущего шага
    * Проверка, что в поисковой выдаче не больше 1 товаров
    * Проверить, что наименование товара соответствует сохраненному значению

