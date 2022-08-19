Feature: Тестирование флоу открытой части

  Scenario: Получаем список закупок и логируем их цены и количество
      When Click "Поставщикам" in "223-ФЗ" column in footer
      And Click "Расширенный поиск" on suppliers page
      And Click "Настройка поиска" on advanced search page
      And Select "615-ПП" checkbox on search settings modal window
      And Select "Исключить совместные закупки" checkbox on search settings modal window
      And Open "Фильтры по датам" category on search settings modal window
      And Enter today's date in "Подача заявок" from/to fields
      And Open "Регион поставки" category on search settings modal window
      And Enter "Алтайский край" in delivery region input field
      And Click find button
      And Load more trades until all of them are loaded
      Then Collect and log data on prices and quantity


