import 'package:http/http.dart' as http;
import 'dart:convert';
var uri = "http://10.0.2.2:8080/";//for local running
class Lobby{
  final int id_lobby;
  final int user1;
  final int user2;
  final int user3;
  final int user4;
  final int user5;
  final int user6;
  final int total_users;

  
  const Lobby({
    required this.id_lobby,
    required this.user1,
    required this.user2,
    required this.user3,
    required this.user4,
    required this.user5,
    required this.user6,
    required this.total_users
  });

  factory Lobby.fromJson(Map<String, dynamic> json){
    return Lobby(
      id_lobby: json['id_lobby'],
      user1:  json['user1'],
      user2:  json['user2'],
      user3:  json['user3'],
      user4:  json['user4'],
      user5:  json['user5'],
      user6:  json['user6'],
      total_users:  json['total_users']
    );
  }
}

class LobbyService{
  Future<List<Lobby>> getLobby() async{
    final response = await http.get(Uri.parse(uri+'lobby'));
    if(response.statusCode ==200){
      final data=jsonDecode(response.body);
      final List<Lobby> list =[];
      for (var i=0; i<data.length; i++){
        final entry = data[i];
        list.add(Lobby.fromJson(entry));
      }
      return list;
    }else{
      throw Exception('HTTP Failed');
    }
  }
}