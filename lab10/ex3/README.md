## Lab10- ex3 Mediator

### 1 - Problema
Criar um programa para gerir uma estaçao de comboios, ou seja saber se um comboio pode chegar a estação sem encontrar nenhum comboio ou outro obstaculo na linha, sem haver a necessidade de os comboios se comunicarem entre eles. 

##### Details      
O programa vai ter as seguintes classes:
- RailwayStationMediator.java: interface for communication between objects, its the mediator as the following methods:
    - registerTrainLine(TrainLine trainLine)
    - registerArrivel(Arrivel arrivel)
    - canArrive()
    - setArrivelStatus(boolean status)

- Command.java: defines the interface for communication with other objects, has the method arrive


- ArrivelMediator.java: its the concrete mediator coordinates the communication between the objects

- Arrivel.java and TrainLine.java: - implements the command interface and communicates with other objects(TrainLine and Arrivel) through the mediator

- Main.java




###### fontes

https://refactoring.guru/design-patterns/mediator

