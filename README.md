# OK! AI.Censor Java API
Implementacja publicznego API OK! AI.Censor w Javie.

## Przykładowe użycie
```java
// dane uwierzytelniające
String token = "TWOJ-TOKEN";

// tworzymy context (w większości przypadków należy go gdzieś zapisać)
ApiContext apiContext = new ApiContext(token);
```

## Pobieranie przewidywań
```java
String phrase = "o cie k u r//w@!";
CensorPredictionInfo prediction = CensorPredictionInfo.getPrediction(apiContext, phrase);
System.out.println(prediction);
```