import pandas as pd
from matplotlib import pyplot as plt
from matplotlib import style
from dateutil import parser as dt_parser


# Загружаем данные из csv файла
# sep - формат данных на основе регулярных выражений, чтобы не быдо ошибок
data = pd.read_csv('результаты_модуля_mainFunc.csv',sep=r'\s*;\s*', header=0, encoding='utf8', engine='python')

# стиль графика
style.use('ggplot')

# преобразуем значения из csv в понятный для библиотеки формат
x = data['x'].to_numpy()
y = data['y'].to_numpy()


# даем название осям и графику
plt.xlabel('x')
plt.ylabel('y')

# рисуем точки
plt.plot(x, y)

# показываем график
plt.show()
