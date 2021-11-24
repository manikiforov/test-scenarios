function testClientInContext() {
  $reactions.answer(
    "[JS-файл] $context.hasOwnProperty('client'): " +
      $context.hasOwnProperty("client")
  );
}

function testClientInJcapiContext() {
  $reactions.answer(
    "[JS-файл] $jsapi.context().hasOwnProperty('client'): " +
      $jsapi.context().hasOwnProperty("client")
  );
}
