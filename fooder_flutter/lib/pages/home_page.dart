

import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:fooder_flutter/lobby_service.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  late Future<List<Lobby>> futureLobby;
  @override
  void initState() {
    super.initState();
    futureLobby = LobbyService().getLobby();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //Appbar that appears at the top of the screen
      appBar: AppBar(
        title: const Text('Fooder'),
        centerTitle: true,
      ),
      //The body is all widgets that are included on the entire page
      body: Column(
          //Column includes a list of children
          children: [
            //TODO_Add a child that displays the logo image
            //* Buttons child: 'Create' and 'Join' Elevated buttons
            SizedBox(
                width: double.infinity,
                child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    //The SizedBox contains 2 children
                    children: <Widget>[
                      //'Create' button
                      ElevatedButton(
                          onPressed: () {
                            if (kDebugMode) {
                              //TODO_Change this to lead to main swiping page

                              print('Create button pressed');
                            }
                          },
                          child: const Text('Create')),
                      //Join button
                      ElevatedButton(
                          onPressed: () {
                            if (kDebugMode) {
                              //TODO_Change this to lead to main swiping page
                              print('Join button pressed');
                            }
                          },
                          child: const Text('Join'))
                    ])),
            Center(
              child: FutureBuilder<List<Lobby>>(
                future: futureLobby,
                builder: ((context, snapshot) {
                  if (snapshot.hasData) {
                    return ListView.separated(
                        scrollDirection: Axis.vertical,
                        shrinkWrap: true,
                        itemBuilder: (context, index) {
                          Lobby lobby = snapshot.data![index];
                          return ListTile(
                            title: Text('${lobby.id_lobby}')
                          );
                        },
                        separatorBuilder: (context, index) {
                          return const Divider(
                            color: Colors.black38,
                          );
                        },
                        itemCount: snapshot.data!.length);
                  } else if (snapshot.hasError) {
                    return Text('Error:${snapshot.error}');
                  }
                  return const CircularProgressIndicator();
                }),
              ),
            )
          ]),
    );
  }
}
