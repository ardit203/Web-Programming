<div id="region-main" class="region-main-content">
                    <span class="notifications" id="user-notifications"></span>
                        <span id="maincontent"></span>
                            <h2>Лабораториска вежба 2 - за групите со префикс Б</h2>
                        <div class="activity-header" data-for="page-activity-header">
                                <span class="sr-only">Completion requirements</span>
                                <div data-region="activity-information" data-activityname="Лабораториска вежба 2 - за групите со префикс Б" class="activity-information">


</div>
</div>
                    <div role="main"><div class="box py-3 generalbox center clearfix"><div class="no-overflow"><h3>Лабораториска вежба 2 Б</h3>

<p>Во оваа вежба ќе треба да продолжите со работа во рамки на проектот од претходната лабораториска вежба.</p>

<hr>

<h4>1. Модели</h4>

<p>Во класата Dish додадете уште едно својство <code>private Long id</code> кое е уникатно за секое јадење. Притоа, id генерирајте го за секое јадење како што е направено во аудиториската вежба (со статички counter или слично).</p>

<hr>

<h4>2. Repository слој</h4>

<p>Креирајте CRUD функционалност за Dish.</p>

<p>Проширете го интерфејсот <code>DishRepository</code> во пакетот <code>mk.ukim.finki.wp.lab.repository</code>:</p>

<pre><code class="java">public interface DishRepository {
    List&lt;Dish&gt; findAll();
    Dish findByDishId(String dishId);
    Optional&lt;Dish&gt; findById(Long id);
    Dish save(Dish dish);
    void deleteById(Long id);
}
</code></pre>

<p>Креирајте <code>InMemoryDishRepository</code> класа која го имплементира овој интерфејс.</p>

<p>Имплементација:
- <code>findAll()</code> – ја враќа листата DataHolder.dishes</p>

<ul>
<li><p><code>findByDishId(String dishId)</code> – го враќа јадењето по dishId</p></li>
<li><p><code>findById(Long id)</code> – го враќа јадењето по Long id</p></li>
<li><p><code>save(Dish dish)</code> – ако постои ажурирај, инаку додади ново</p></li>
<li><p><code>deleteById(Long id)</code> – избришете го јадењето од листата</p></li>
</ul>

<hr>

<h4>3. Service слој</h4>

<p>Проширете го <code>DishService</code> интерфејсот во пакетот <code>mk.ukim.finki.wp.lab.service</code>:</p>

<pre><code class="java">public interface DishService {
    List&lt;Dish&gt; listDishes();
    Dish findByDishId(String dishId);
    Dish findById(Long id);
    Dish create(String dishId, String name, String cuisine, int preparationTime);
    Dish update(Long id, String dishId, String name, String cuisine, int preparationTime);
    void delete(Long id);
}
</code></pre>

<p>Креирајте <code>DishServiceImpl</code> класа која го имплементира <code>DishService</code>.<br>
<code>DishServiceImpl</code> треба да зависи од <code>DishRepository</code>.</p>

<hr>

<h4>4. Web слој — контролери и погледи</h4>

<p>Сега преминуваме на Spring MVC контролери (без сервлети).</p>

<p>Креирајте пакет <code>mk.ukim.finki.wp.lab.web.controller</code> и во него <code>DishController</code>.</p>

<hr>

<h4>4.1 Метод за листање на јадења</h4>

<p>Имплементирајте метод:</p>

<p><code>public String getDishesPage(@RequestParam(required = false) String error, Model model)</code> кој треба да го прикаже погледот listDishes.html со приказ на сите јадења.</p>

<p>Нека одговара на mapping: /dishes.</p>

<p>До секое јадење додадете две копчиња:
- едно за едитирање на јадењето,
- едно за бришење на јадењето.</p>

<hr>

<h4>4.2 Додавање ново јадење</h4>

<p>Имплементирајте метод:</p>

<p><code>public String saveDish(@RequestParam String dishId,
                       @RequestParam String name,
                       @RequestParam String cuisine,
                       @RequestParam int preparationTime)</code></p>

<p>Кој ќе овозможи додавање на ново јадење и ќе одговара на mapping: /dishes/add.
При успешно додавање редиректирајте кон /dishes.</p>

<hr>

<h4>4.3 Ажурирање јадење</h4>

<p>Имплементирајте метод:</p>

<p><code>public String editDish(@PathVariable Long id,
                       @RequestParam String dishId,
                       @RequestParam String name,
                       @RequestParam String cuisine,
                       @RequestParam int preparationTime)</code></p>

<p>Нека одговара на mapping: /dishes/edit/{id}<br>
При успешно ажурирање → редирект кон /dishes.</p>

<hr>

<h4>4.4 Бришење јадење</h4>

<p>Имплементирајте метод:
<code>public String deleteDish(@PathVariable Long id)</code></p>

<p>Mapping: /dishes/delete/{id} .
По успешно бришење → повторно прикажете ја листата со јадења.</p>

<hr>

<h4>5. Поврзани сервис и repository методи</h4>

<p>Креирајте ги сите потребни методи во сервис и репозиториум слојот согласно контролерите.<br>
Сè останува in-memory како во претходната вежба.</p>

<hr>

<h4>6. Страници (views)</h4>

<h5>6.1 <code>dish-form.html</code></h5>

<p>Креирајте страна за додавање/уредување на јадење.</p>

<p>Формата треба да содржи полиња:
- dishId
- name
- cuisine
- preparationTime</p>

<p>Истата форма да се користи и за додавање и за уредување (како на вежби).</p>

<hr>

<h5>6.2 <code>listDishes.html</code></h5>

<ul>
<li>Прикажете ги сите јадења (dishId, name, cuisine, preparationTime)</li>
<li>Додадете копче за уредување</li>
<li>Додадете копче за бришење</li>
<li>Додадете копче за додавање ново јадење</li>
</ul>

<hr>

<h4>7. Дополнителни рути за форми</h4>

<p>Имплементирајте метод:
<code>public String getEditDishForm(@PathVariable Long id, Model model)</code></p>

<p>Mapping: /dishes/dish-form/{id}</p>

<p>При уредување прикажете ги постоечките податоци.<br>
Ако id не постои → редирект кон /dishes?error=DishNotFound.</p>

<p>Имплементирајте метод:
<code>public String getAddDishPage(Model model)</code></p>

<p>Mapping: /dishes/dish-form<br>
Прикажува празна форма за додавање ново јадење.</p>

<hr>

<h4>8. Интеграција со Chef</h4>

<p>Во <code>DishController</code> оставете ја функционалноста за додавање јадење кај готвач (од Лаб 1Б).<br>
<code>ChefService</code> и <code>DishService</code> треба да функционираат заедно како претходно.</p>

<hr>

<h4>9. Проверка</h4>

<p>Проверете:
- прикажување на сите јадења
- додавање, уредување и бришење на јадења
- правилна работа на формите
- правилно функционирање со Chef модулот од претходната вежба</p>
