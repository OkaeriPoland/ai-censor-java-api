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
CensorPredictionInfo prediction = CensorPredictionInfo.get(apiContext, phrase);
System.out.println(prediction);
// czy jest to wulgarne?
boolean swear = prediction.getGeneral().isSwear();
```

- [CensorPredictionInfo](https://github.com/OkaeriPoland/ai-censor-java-api/blob/master/src/main/java/eu/okaeri/aicensor/api/info/CensorPredictionInfo.java)