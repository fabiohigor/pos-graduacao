import { FC } from "react";

type MeuNomeProps = {
  name: string;
  age: number;
  birtDate: Date;
}

export const MeuNome: FC<MeuNomeProps> = ({name, age, birtDate}) => (  
    <p>Meu nome é {name} e tenho {age} anos porque nasci no dia {" "} {birtDate.toLocaleDateString("pt-BR")}</p>
);