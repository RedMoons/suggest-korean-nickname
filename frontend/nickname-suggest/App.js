import React, { useEffect } from 'react';
import { SafeAreaView, StyleSheet, Text, TextInput, View } from "react-native";
import { Button } from "react-native-paper";
import {
  AdMobBanner,
  AdMobInterstitial,
  PublisherBanner,
  AdMobRewarded,
  setTestDeviceIDAsync,
} from 'expo-ads-admob';

export default function App() {
  const [loading, setLoading] = React.useState(true);
  const [text, setText] = React.useState("");
  const [suggestName, setSuggestName] = React.useState("");
  const [pronounce, setPronounce] = React.useState("");


  const handleClick = () => {
    fetch(
      `http://localhost:8080/female/${text}`,
    )
    .then(res => res.json())
    .then(response => {
      setSuggestName(response[0]);
      setPronounce(response[1]);
      setLoading(false);
    })    
  }

  // async showInterstitial(){
  //   AdMobInterstitial.setAdUnitID('ca-app-pub-3940256099942544/1033173712'); // Test ID, Replace with your-admob-unit-id
  //   AdMobInterstitial.requestAdAsync({ servePersonalizedAds: true});
  //   AdMobInterstitial.showAdAsync();
  // }

  const showInterstitial= async () => {
    AdMobInterstitial.setAdUnitID('ca-app-pub-3940256099942544/1033173712'); // Test ID, Replace with your-admob-unit-id
    AdMobInterstitial.requestAdAsync({ servePersonalizedAds: true});
    AdMobInterstitial.showAdAsync();
  }
  const goBack = () => {
    {showInterstitial}
    setSuggestName("");
    setPronounce("");
    setLoading(true);
  }

  useEffect(() => {
    
  }, [loading]);


  if (loading) {
    return (
      <SafeAreaView style={styles.container}>
        
        <Text style={styles.titleText}>{"\n"}Suggest Korean Female Nickname{"\n"}{"\n"}{"\n"}</Text>
          <TextInput
          style={styles.inputText}
          onChangeText={input => setText(input)}
          placeholder="Please type your name(lower alphabet only)"
          value={text.replace(/[^a-z]/g, '')}
        />
        <Button
          style={styles.submitButton}
          mode="contained"
          onPress={handleClick}
        >
          Submit
        </Button>
        <Text style={styles.titleText}>
          {suggestName} 
          {pronounce}
        </Text>
        <AdMobBanner
          bannerSize="fullBanner"
          style={styles.bottomBanner}
          // adUnitID="ca-app-pub-4002786977128549/3343757792" // real ID
          adUnitID="ca-app-pub-3940256099942544/6300978111" // Test ID, Replace with your-admob-unit-id
          servePersonalizedAds // true or false
        />
        
      </SafeAreaView>

    );
  }else{
    return (
      <SafeAreaView >
        
        <Text style={styles.titleText}>{"\n"} Suggest Korean Female Nickname {"\n"}{"\n"}{"\n"}{"\n"}{"\n"}</Text>
        <Text style={styles.titleText}>
          {suggestName} 
          {pronounce}
        </Text>
        <Button 
          mode="contained"
          onPress={goBack}
        >
          Go Back
        </Button>
      </SafeAreaView>
    )
  }
  
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  baseText: {
    fontFamily: "Cochin"
  },
  titleText: {
    textAlign: 'center',
    fontSize: 20
  },
  submitButton: {
    position: 'absolute',
    bottom: 80,
    right:5
  },
  bottomBanner: {
    position: "absolute",
    bottom: 0
  },
  inputText: {
    height: 40,
    margin: 12,
    borderWidth: 1,
    padding: 10,
  },
});