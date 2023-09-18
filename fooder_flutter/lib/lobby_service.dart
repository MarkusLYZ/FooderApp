
import 'package:http/http.dart' as http;
import 'dart:convert';
var uri = "10.0.2.2:8080";//for local running
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

  Map<String, dynamic> toJson(){
    final Map<String, dynamic> data = <String, dynamic>{};
    data['id_lobby'] = id_lobby.toString();
    data['user1'] = user1.toString();
    data['user2'] = user2.toString();
    data['user3'] = user3.toString();
    data['user4'] = user4.toString();
    data['user5'] = user5.toString();
    data['user6'] = user6.toString();
    data['total_users'] = total_users.toString();
    return data;

  }
}

class LobbyService{
  Lobby defaultLobby = const Lobby(id_lobby: 1 , user1: 1, user2: 0, user3: 0, user4: 0, user5: 0, user6: 0, total_users: 1);
  Future<List<Lobby>> getAllLobby() async{
    final reqUri = Uri.http(uri, '/lobby');
    final response = await http.get(reqUri);     
    if(response.statusCode ==200){
      final data=jsonDecode(response.body);
      final List<Lobby> list =[];
      for (var i=0; i<data.length; i++){
        final entry = data[i];
        list.add(Lobby.fromJson(entry));
      }
      print('lobby list http responsive');
      return list;
    }else{
      throw Exception('HTTP Failed');
    }
  }
  
  Future <Lobby> createLobby() async{
    //print(defaultLobby.toJson());
    final reqUri = Uri.http(uri, '/lobby');
    final response = await http.post(reqUri, body: defaultLobby.toJson());
    if(response.statusCode ==200){
      final data=jsonDecode(response.body);
      Lobby newLobby = Lobby.fromJson(data);
      print('create lobby http responsive');
      return newLobby;
    }else{
      throw Exception('HTTP Failed');
    }

  } 
}