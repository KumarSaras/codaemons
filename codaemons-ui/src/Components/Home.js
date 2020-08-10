import React from "react";
import Navbar from "./Navbar";
import Contest from './Contest'
//import { ActivityIndicator, View } from 'react-native'

export default function Home() {
  return (
    <div className="wrapper">
      <Navbar />
    <Contest/>
    </div>
  );
}

/*
<View style={{flex: 1, padding: 20}}>
    <ActivityIndicator/>
</View>
*/
