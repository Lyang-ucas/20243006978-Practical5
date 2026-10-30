# Practical5

Huang leyang  
Student ID: 20243006978

This is the Chinese Municipalities app for Practical 5. It uses Java and XML layouts.

## Run the app

Open this folder in Android Studio and wait for Gradle sync. Use the bundled JDK and install Android SDK 37 if needed. Run `app` on an emulator or a phone with Android 7.0 or later.

Type Beijing, Shanghai, Tianjin or Chongqing, then press Go or Enter. The next screen shows the city name, photo and a short introduction. Visit site opens the city's official website in a browser.

## Main files

- `MainActivity.java` reads the input and passes the city name with an explicit Intent.
- `TextProcessor.java` checks the name, removes spaces at both ends and accepts different letter cases.
- `Municipality.java` chooses the resources and opens the website with an implicit Intent.
- `arrays.xml` stores the introductions in the order Beijing, Shanghai, Chongqing, Tianjin, as stated in the task.

The photos and launcher logo come from the practical resources. The map was converted to JPG to match the required filename. The images were resized for use on a phone. Chongqing uses a dark background behind the orange information text to make it easier to read.

## Input checks

| Input | Expected result |
| --- | --- |
| Beijing, beijing, BEIJING | Beijing screen |
| Shanghai | Shanghai screen |
| Tianjin | Tianjin screen |
| Chongqing | Chongqing screen |
| Guangzhou | Error on the main screen |
| Empty input or spaces only | Error on the main screen |

The app was checked on the Pixel 10 Pro XL emulator. The four city screens show the matching photos, introductions and colours. The input box stays above the keyboard. One Enter press opens one city screen. Each Visit site button passes the matching official URL to the browser. A browser and an internet connection are needed to load the websites.

## Sources for the introductions

- Beijing: [City overview](https://www.beijing.gov.cn/renwen/bjgk/) and [places to visit](https://english.beijing.gov.cn/travellinginbeijing/mustvisitsites/).
- Shanghai: [City overview](https://english.shanghai.gov.cn/en-Overview/20231209/705180b43f794c1ca43f4d1ddaa049a2.html) and [Shanghai facts](https://english.shanghai.gov.cn/cmsres/b2/b28c98aa466c4e0a9c1ec572ff6e51f0/4870ef4d844b264c050bc9ad4be6bf71.pdf).
- Chongqing: [City overview](https://www.cq.gov.cn/zjcq/sqgk/cqsq/202412/t20241231_14378256.html) and [municipality background](https://english.scio.gov.cn/m/pressroom/2022-08/18/content_78386110.htm).
- Tianjin: [Historical origins](https://en.tj.gov.cn/tianjininfo/profile/202312/t20231225_6489676.html).
