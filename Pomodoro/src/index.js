import React from 'react';
import ReactDOM from 'react-dom';
import styled from 'styled-components';
import { Settings, Submit } from './Components';
import './index.css';

class Pomodoro extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      minutesT: 0,
      secondesT: 0,
      minutesP: 0,
      secondesP: 0,
      minutes: 0,
      secondes: 0,
      round: 1,
      roundConst: 1,
      travail: true,
      settings: true,
      finish: false,
    };
  }

  play = () => {
    this.initValue(this.state.round);
    this.inter = setInterval(this.timer, 1000);
    document.getElementById('playBtn').disabled = true;
  };

  pause = () => {
    clearInterval(this.inter);
    if (document.getElementById('playBtn'))
      document.getElementById('playBtn').disabled = false;
  };

  initValue = (round) => {
    if (this.state.travail) {
      this.setState({
        minutes: this.state.minutesT,
        secondes: this.state.secondesT,
        round: round,
      });
    } else {
      this.setState({
        minutes: this.state.minutesP,
        secondes: this.state.secondesP,
        round: round,
      });
    }
  };

  restart = () => {
    this.initValue(this.state.roundConst);
    this.setState({ travail: true, finish: false });
    this.pause();
  };

  timer = () => {
    this.setState({ secondes: this.state.secondes - 1 });
    if (
      this.state.minutes === 0 &&
      this.state.secondes === 0 &&
      this.state.round > 0
    ) {
      if (!this.state.travail) {
        this.setState({
          round: this.state.round - 1,
        });
      }

      this.setState({
        travail: !this.state.travail,
      });

      if (this.state.round !== 0) {
        this.pause();
        this.play();
      } else {
        this.pause();
        this.setState({
          finish: !this.state.finish,
        });
      }
    }

    if (this.state.secondes === 0) {
      this.setState({ minutes: this.state.minutes - 1, secondes: 60 });
    }
  };

  settings = () => {
    this.initValue(this.state.roundConst);
    this.setState({ settings: !this.state.settings, finish: false });
  };

  setTime = (minutesT, secondesT, minutesP, secondesP, round) => {
    this.setState({
      minutesT: minutesT,
      secondesT: secondesT,
      minutesP: minutesP,
      secondesP: secondesP,
      round: round,
      roundConst: round,
    });
    this.setState({ settings: !this.state.settings });
  };

  render() {
    if (this.state.settings) {
      return (
        <>
          <Settings
            setTime={this.setTime}
            minutesT={this.state.minutesT}
            secondesT={this.state.secondesT}
            minutesP={this.state.minutesP}
            secondesP={this.state.secondesP}
            round={this.state.round}
          />
        </>
      );
    } else if (this.state.finish) {
      return (
        <Finish>
          <Submit onClick={this.settings}>Settings</Submit>
          <h1>Bravo vous avez terminé votre exercice !</h1>
          <Submit onClick={this.restart}>Recommencer</Submit>
        </Finish>
      );
    } else {
      return (
        <Container isTravail={this.state.travail}>
          <Submit onClick={this.settings}>Setting</Submit>
          <h1>{this.state.travail ? 'Travail' : 'Pause'}</h1>
          <h2>Tour : {this.state.round}</h2>
          <p style={styles.compteur}>
            {this.state.minutes}:{this.state.secondes}
          </p>
          <div>
            <Submit id='playBtn' onClick={this.play}>
              Play
            </Submit>
            <Submit onClick={this.pause}>Pause</Submit>
            <Submit onClick={this.restart}>Restart</Submit>
          </div>
        </Container>
      );
    }
  }
}

const styles = {
  compteur: {
    fontSize: 150,
    margin: 0,
  },
};

const Container = styled.div`
  font-family: 'Montserrat', sans-serif;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  background: ${(props) => {
    if (props.isTravail) return '#A8201A';
    else return '#363636';
  }};
  color: white;
  width: 100vw;
  height: 100vh;
`;

const Finish = styled.div`
  font-family: 'Montserrat', sans-serif;

  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  background: #89ce94;
  color: white;
  width: 100vw;
  height: 100vh;
`;

const rootElt = document.getElementById('root');
ReactDOM.render(<Pomodoro />, rootElt);
