# PBRestAssured

## Run locally options
Options run locally restAssured tests:
### `mvn test -DsuiteXmlFile=src/test/resources/api.xml`

Options run locally ui tests:
### `mvn test -Dbrowser=chrome -DsuiteXmlFile=src/test/resources/ui.xml  -Dscreen=M_S`
### `mvn test -Dbrowser=firefox -DsuiteXmlFile=src/test/resources/ui.xml  -Dscreen=D_S`
### `mvn test -Dbrowser=MicrosoftEdge -DsuiteXmlFile=src/test/resources/ui.xml`
### `mvn test -Dbrowser=safari -DsuiteXmlFile=src/test/resources/ui.xml`

## Options run with different screen sizes
-Dscreen  --> com.core.models.enums.ScreenSize  --> com.core.providers.ScreenProvider
DESKTOP_L(1920 x 1080),
DESKTOP_M(1536 x 864),
DESKTOP_S(1280 x 720),
MOBILE_M(414 x 896),
MOBILE_S(360 x 800),
TABLET(768 x 1024);