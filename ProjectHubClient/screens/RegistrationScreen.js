import React from 'react';
import { View, Text , TextInput, Button} from 'react-native';
import { useState, useEffect } from 'react';
import axios from 'axios';




const RegistrationScreen = ({ navigation }) => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
  
    const handleRegister = async () => {
        try {
          // Prepare the user registration data as an object
          const userData = {
            firstName,
            lastName,
            email,
            password,
          };
      
          // Send an HTTP POST request to the server's registration endpoint
          const response = await axios.post('https://localhost:8080/api/users/register', userData);
      
          // Handle the response from the server
          if (response.status === 200) {
            // Registration successful, navigate to the Home screen
            navigation.navigate('HomeScreen');
          } else {
            // Registration failed, display an error message or handle the error accordingly
            console.log('Registration failed:', response.data);
          }
        } catch (error) {
          // Handle any other errors that occurred during the registration process
          console.log('Error during registration:', error);
        }
      };
  
    return (
      <View>
        <TextInput
          placeholder="First Name"
          value={firstName}
          onChangeText={text => setFirstName(text)}
        />
        <TextInput
          placeholder="Last Name"
          value={lastName}
          onChangeText={text => setLastName(text)}
        />
        <TextInput
          placeholder="Email"
          value={email}
          onChangeText={text => setEmail(text)}
        />
        <TextInput
          placeholder="Password"
          secureTextEntry
          value={password}
          onChangeText={text => setPassword(text)}
        />
        <Button title="Register" onPress={handleRegister} />
      </View>
    );
  };
  
  export default RegistrationScreen;