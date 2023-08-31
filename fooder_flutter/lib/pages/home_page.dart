import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

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
            ]));
  }
}
