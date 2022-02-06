import React from 'react';
import styled from 'styled-components';

export class Input extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <Styled>
        <label>{this.props.title} :</label>
        <div>
          <InputNumber
            type='number'
            defaultValue={this.props.minutes}
            min='0'
            max='59'
            onChange={this.props.onMinChange}
          />
          :
          <InputNumber
            type='number'
            defaultValue={this.props.secondes}
            min='0'
            max='59'
            onChange={this.props.onSecChange}
          />
        </div>
      </Styled>
    );
  }
}

const Styled = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;

  div {
    font-size: 30px;
  }
`;

const InputNumber = styled.input`
  margin-left: 5px;
  margin-right: 5px;
  width: 70px;
  height: 80px;
  font-size: 30px;
  text-align: center;
  border-radius: 10px;
`;
