import React from 'react';
import {View,StyleSheet} from 'react-native';
import LottieView from 'lottie-react-native';
import loadAnimation1 from '../assets/13679-fast-food-mobile-app-loading.json';
import loadAnimation2 from '../assets/30754-food-delivery-services-animation.json';

const loads = [loadAnimation1,loadAnimation2];

const Load = () =>{
  function getRndInteger(min:number, max:number) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
  }

  return(
    <View style={styles.container}>
      <LottieView 
      source={loads[getRndInteger(0,1)]}
      autoPlay
      loop
      style={styles.animation}
      />
    </View>
  );
}
const styles = StyleSheet.create({
container:{
  flex: 1,
  justifyContent: 'center',
  alignItems: 'center'
},
animation: {
  backgroundColor: 'transparent',
  width: 200,
  height: 200,
}
})

export default Load;