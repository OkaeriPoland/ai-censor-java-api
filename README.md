# OK! AI.Censor Java Client
Implementacja publicznego API OK! AI.Censor w Javie.

## Przykładowe użycie
```java
// dane uwierzytelniające
String token = "TWOJ-TOKEN";

// tworzymy context (w większości przypadków należy go gdzieś zapisać)
CensorApiContext apiContext = new CensorApiContext(token);
```

## Pobieranie przewidywań
```java
// zapytanie
String phrase = "o cie k u r//w@!";
CensorPredictionInfo prediction;
try {
    prediction = CensorPredictionInfo.get(apiContext, phrase);
} catch (ApiException exception) {
    // TODO: obsluga bledu, np. sprawdzanie lokalna lista lub odrzucenie dodawania wiadomosci z bledem do uzytkownika
    exception.printStackTrace();
    return;
}
System.out.println(prediction);
// czy jest to wulgarne?
boolean swear = prediction.getGeneral().isSwear();
```

## Opis zwracanych własności

#### CensorPredictionInfo [[link]](https://github.com/OkaeriPoland/ai-censor-java-client/blob/master/src/main/java/eu/okaeri/aicensor/client/info/CensorPredictionInfo.java)

| Własność  | Opis |
| ------------- | ------------- |
| UUID #getId() | Zwraca unikalne id zapytania zapisanego w systemie AI.Censor |
| CensorPredictionGeneralInfo #getGeneral() | Sekcja ogólna odpowiedzi |
| CensorPredictionDetailsInfo #getDetails() | Sekcja szczegółów odpowiedzi |
| CensorPredictionElapsedInfo #getElapsed() | Sekcja informacji dotyczących czasu przetwarzania |


#### CensorPredictionGeneralInfo [[link]](https://github.com/OkaeriPoland/ai-censor-java-client/blob/master/src/main/java/eu/okaeri/aicensor/client/info/CensorPredictionGeneralInfo.java)

| Własność  | Opis |
| ------------- | ------------- |
| boolean #isSwear() | Informacja o tym, czy wiadomość została uznana za wulgarną |
| String #getBreakdown() | Przetworzona wiadomość ułatwiająca ewentualne debugowanie błędnych wykryć, przydatna do wyświetlania dla administracji w logach |
| boolean #hasDomains() | Informacja o tym, czy wiadomość zawiera nazwy domenowe istniejące w systemie DNS |


#### CensorPredictionDetailsInfo [[link]](https://github.com/OkaeriPoland/ai-censor-java-client/blob/master/src/main/java/eu/okaeri/aicensor/client/info/CensorPredictionDetailsInfo.java)

| Własność  | Opis |
| ------------- | ------------- |
| boolean #isBasicContainsHit() | Informacja o tym, czy wiadomość zawierała zakazane frazy |
| boolean #isExactMatchHit() | Informacja o tym, czy wiadomość była zablokowaną frazą (np. wyrażenie jd) |
| String #getAiLabel() | Ocena ai (`ok` lub `swear`) |
| double #getAiProbability() | Wartość od `0` do `1` określająca prawdopodobieństwo dotyczące prawdziwości `aiLabel` |
| List<String> #getDomainsList() | Lista domen obecnych w wiadomości |


#### CensorPredictionElapsedInfo [[link]](https://github.com/OkaeriPoland/ai-censor-java-client/blob/master/src/main/java/eu/okaeri/aicensor/client/info/CensorPredictionElapsedInfo.java)

| Własność  | Opis |
| ------------- | ------------- |
| double #getAll() | Całkowity czas w milisekundach przez który zapytanie było obsługiwane wewnętrznie |
| double #getProcessing() | Czas przez jaki zostały wykonane oceny wulgarności |
