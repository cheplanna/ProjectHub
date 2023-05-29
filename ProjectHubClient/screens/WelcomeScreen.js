import React from 'react';
import { View, Button } from 'react-native';

const WelcomeScreen = ({ navigation }) => {
  return (
    <View>
      <Button title="Войти" onPress={() => navigation.navigate('Login')} />
      <Button title="Регистрация" onPress={() => navigation.navigate('Registration')} />
    </View>
  );
};

export default WelcomeScreen;
