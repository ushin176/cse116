package fJson

import play.api.libs.json.{JsValue, Json}

object json1{

  val json: JsValue = Json.parse("""
  {
  {"playerParty":party, "enemyParty":party},

    "_comment": "{"battleOptions": ["Shield Defence", "Thunder Sword", "Knight strike", "Regen HP"]}"
    "_comment": "{name: John Wick}"

    {"characters":[ {
    "name":"",
    "hp":50,
    "maxHP":70,
    "battleOptions": ["","","",""]

    } ]
  }
  """)


}
