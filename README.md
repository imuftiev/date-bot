# Date-bot

**Date-bot** — это простой 
Telegram-бот, который помогает легко 
и непринужденно пригласить девушку на свидание, 
например, на чашку кофе. Бот генерирует вежливое и 
милое приглашение.
---

## Функционал

- Генерация приглашения на свидание по команде `/start`
- Легкий и понятный интерфейс
- Настроен для работы на платформе Telegram
- Написан на Java с использованием библиотеки [telegrambots API](https://github.com/rubenlagus/TelegramBots)

---

## Как использовать

1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/imuftiev/date-bot.git
2. Изменяйте под свои предпочтения

## Структура проекта:
### src.main.java.com.project.princeps — app package
- bot — содержит класс с настройкой бота
- config — инициализация и конфиг бота (регистрация TelegramBotsApi)
- controller — обработчик события "Update"
- dto — DTO для сущностей
- entity — модели таблиц баз данных
- handler — обработчик комманд
- mapper — мапперы для сущностей
- repository — репозитории для сущностей
- service — сервисная логика бота
- util — утилиты для бота, содержит Enum класс для (State Machine)

### src.main.resources — resources package
- application.yml — файл конфигурации приложения, данные все сохранены в .env файле в корневой папке проекта
