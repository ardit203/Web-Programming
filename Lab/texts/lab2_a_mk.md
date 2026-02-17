<div id="region-main" class="region-main-content">
                    <span class="notifications" id="user-notifications"></span>
                        <span id="maincontent"></span>
                            <h2>Лабораториска вежба 2 - за групите со префикс А</h2>
                        <div class="activity-header" data-for="page-activity-header">
                                <span class="sr-only">Completion requirements</span>
                                <div data-region="activity-information" data-activityname="Лабораториска вежба 2 - за групите со префикс А" class="activity-information">


</div>
</div>
                    <div role="main"><div class="box py-3 generalbox center clearfix"><div class="no-overflow"><h3><strong>Лабораториска вежба 2 А</strong></h3>

<p>Во оваа вежба ќе треба да продолжите со работа во рамки на проектот од претходната лабораториска вежба.</p>

<hr>

<h4><strong>1. Модели</strong></h4>

<p>Во класата <strong>Book</strong> додадете уште едно својство:</p>

<pre><code class="java">private Long id;
</code></pre>

<p>кое е уникатно за секоја книга. Притоа, <code>id</code> генерирајте за секоја книга, како што е направено во рамки на аудиториската вежба.</p>

<p>Додадете класа <strong>Author</strong> во рамки на пакетот <code>mk.ukim.finki.wp.lab.model</code>. Во истата ќе чувате:</p>

<pre><code class="java">private Long id;
private String name;
private String surname;
private String country;
private String biography;
</code></pre>

<p>Во класата <strong>Book</strong> додадете врска до класата <strong>Author</strong> како посебно својство:</p>

<pre><code class="java">private Author author;
</code></pre>

<hr>

<h4><strong>2. Repository слој</strong></h4>

<p>Креирајте <strong>AuthorRepository</strong> класа во пакетот <code>mk.ukim.finki.wp.lab.repository</code>. Во класата <code>DataHolder</code> иницијализирајте листа во која ќе има 3 автори. (како во кодот од вежби)
Во рамки на класата напишете и метод:</p>

<pre><code class="java">public List&lt;Author&gt; findAll()
</code></pre>

<p>кој ги враќа сите автори што постојат во системот.<br>
За секоја од книгите иницијализирајте некој од авторите во атрибутот <code>author</code>.</p>

<hr>

<h4><strong>3. Service слој</strong></h4>

<p>Во рамки на пакетот <code>mk.ukim.finki.wp.lab.service</code> креирајте интерфејс <strong>AuthorService</strong> како и класа која го имплементира <strong>AuthorServiceImpl</strong> (во <code>impl</code> потпакетот).<br>
Нека во овој сервис се креира метод:</p>

<pre><code class="java">public List&lt;Author&gt; findAll()
</code></pre>

<p>кој го повикува соодветниот метод од <strong>AuthorRepository</strong>.</p>

<hr>

<h4><strong>4. Web слој — контролер и погледи</strong></h4>

<p>Дефинирајте пакет <code>mk.ukim.finki.wp.lab.web.controller</code> и во него креирајте ја <strong>BookController</strong> класата.</p>

<h5><strong>4.1 Метод за листање</strong></h5>

<p>Имплементирајте метод:</p>

<pre><code class="java">public String getBooksPage(@RequestParam(required = false) String error, Model model)
</code></pre>

<p>кој треба да го прикаже погледот на сите книги.<br>
Нека одговара на mapping <strong><code>/books</code></strong>.<br>
Погледот на сите книги нека биде <strong><code>listBooks.html</code></strong>, со приказ на името и презимето на авторот, оставајќи ја функционалноста за избирање на книга и број на копии.</p>

<p>До секоја книга додадете две копчиња:
- едно за <strong>едитирање</strong> на книгата;
- друго за <strong>бришење</strong> на книгата.</p>

<hr>

<h5><strong>4.2 Додавање нова книга</strong></h5>

<p>Имплементирајте метод:</p>

<pre><code class="java">public String saveBook(@RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double averageRating,
                       @RequestParam Long authorId)
</code></pre>

<p>кој ќе овозможи додавање на нова книга и ќе одговара на mapping <strong><code>/books/add</code></strong>.<br>
При успешно додавање, нека редиректира кон погледот со сите книги.</p>

<hr>

<h5><strong>4.3 Ажурирање книга</strong></h5>

<p>Имплементирајте метод:</p>

<pre><code class="java">public String editBook(@PathVariable Long bookId,
                       @RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double averageRating,
                       @RequestParam Long authorId)
</code></pre>

<p>кој ќе овозможи ажурирање на книгите.<br>
Нека одговара на mapping <strong><code>/books/edit/{bookId}</code></strong>, и при успешно ажурирање редиректирајте кон листата на книги.</p>

<hr>

<h5><strong>4.4 Бришење книга</strong></h5>

<p>Имплементирајте метод:</p>

<pre><code class="java">public String deleteBook(@PathVariable Long id)
</code></pre>

<p>Нека одговара на mapping <strong><code>/books/delete/{id}</code></strong>, и при успешно бришење повторно нека ја прикажува листата на книги.</p>

<blockquote>
  <p>Внимавајте на анотациите — користете <code>@GetMapping</code> за форми/страници и <code>@PostMapping</code> за креирање, ажурирање и бришење.</p>
</blockquote>

<hr>

<h4><strong>5. Поврзани слоеви</strong></h4>

<p>Креирајте ги сите потребни методи во <strong>service</strong> и <strong>repository</strong> слоевите согласно методите во контролерите.<br>
Сè останува <strong>in-memory</strong> како во претходната вежба.</p>

<hr>

<h4><strong>6. Страници (views)</strong></h4>

<h5><strong>6.1 <code>book-form.html</code></strong></h5>

<p>Креирајте страна за <strong>додавање/уредување</strong> на книга.<br>
Формата треба да содржи полиња за:
- <code>title</code> (наслов)
- <code>genre</code> (жанр)
- <code>averageRating</code> (рејтинг)
- <code>authorId</code> (селект листа со сите автори)</p>

<p>Иста форма да се користи и за додавање и за уредување.</p>

<hr>

<h5><strong>6.2 <code>listBooks.html</code></strong></h5>

<ul>
<li>Прикажете ги сите книги (наслов, жанр, рејтинг, автор).</li>
<li>До секоја книга додадете <strong>копче за уредување</strong> и <strong>копче за бришење</strong>.</li>
<li>Додадете <strong>копче за додавање нова книга</strong>.</li>
<li>Оставете ја постоечката <strong>форма за резервација</strong> (избор на книга и број на копии).</li>
</ul>

<hr>

<h4><strong>7. Дополнителни рути за форми</strong></h4>

<p>Имплементирајте метод:</p>

<pre><code class="java">public String getEditBookForm(@PathVariable Long id, Model model)
</code></pre>

<p>кој одговара на mapping <strong><code>/books/book-form/{id}</code></strong> и ја прикажува <strong><code>book-form.html</code></strong> страната.<br>
При уредување, прикажете ги моменталните податоци за книгата.<br>
Ако <code>id</code> не постои — направете редирект кон <code>/books?error=BookNotFound</code>.</p>

<p>Имплементирајте метод:</p>

<pre><code class="java">public String getAddBookPage(Model model)
</code></pre>

<p>кој одговара на mapping <strong><code>/books/book-form</code></strong> и ја прикажува <strong><code>book-form.html</code></strong> страната.</p>

<hr>

<h4><strong>8. Резервации (BookReservationController)</strong></h4>

<p>Заменете го сервлетот <strong>BookReservationServlet</strong> со <strong>контролер</strong> <code>BookReservationController</code>, кој ќе овозможи:
- креирање нова резервација;
- прикажување на страницата за потврда.</p>

<p>Контролерот треба да:
- ги прочита податоците од формата (книга, број копии, име и адреса);
- ја земе IP адресата на клиентот;
- креира резервација преку сервис;
- ја прикаже <strong><code>reservationConfirmation.html</code></strong> страната со деталите.</p>

<hr>

<h4><strong>9. Проверка</strong></h4>

<p>При тестирање проверете:
- прикажување на сите книги;
- додавање, уредување и бришење книги;
- функционалност на резервацијата и потврдната страница;
- правилно прикажување на авторите во листата.</p>
