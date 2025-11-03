Názov zadania:
Systém na uchovávanie registrovaných návštevníkov jump arény podľa prevádzkového poriadku s vernostnými kartami

Mená členov tímu:

- Matúš Klimko
- Mikuláš Marko

Zámer:

- Registrácia zákazníkov s vypĺňaním prevádzkového formuláru
- Zaslanie QR kódu mailom
- Šetrenie zdrojmi – papier, toner, ...
- Urýchlenie procesu registrácie
- Zaznamenávanie návštev
- moznost vyuzit registraciu na prihlasenie k odberaniu noviniek (subscription plan)

- Adminské rozhranie, správa používateľov
- Superadmin
- Dochádzkový systém zamestnancov s mesačným reportom

Okná:

- Inicializácia pre nastavenie superadmina pri prvom spustení aplikácie
- Hlavné okno – nová registrácia / už registrovaný, prechod do admin rozhrania / dochádzka, sk/en, svetlý/tmavý režim
- Registračné okno - formulár
- Potvrdzovacie okno – súhlas s poriadkom
- Už registrovaný zákazník – načítanie čipovej karty
- Adminské prihlasovacie rozhranie
- Adminské rozhranie
- Zamestnanecké dochádzkové rozhranie
- Superadminské rozhranie

Entity:
- Zákazník
- Zamestnanec/admin/superadmin
- Návšteva

Databáza:

Zákazník:
- Meno
- Priezvisko
- Id
- Dátum narodenia
- E-mail
- Tel. číslo

Zamestnanec:
- Meno
- Priezvisko
- Id
- E-mail
- Tel. číslo
- QR kód (číslo)
- Oprávnenia (admin, superadmin, zamestnanec)

Dochádzka (pre zamestnancov):
- Id záznamu
- Id zamestnanca
- Čas prihlásenia (tttttt:dd:mm:yyyy)
- Čas odhlásenia (tttttt:dd:mm:yyyy)

Registrácia návštev (analytické záležitosti):
- Id záznamu
- Id návštevníka
- Dátum návštevy (tttttt:dd:mm:yyyy)
