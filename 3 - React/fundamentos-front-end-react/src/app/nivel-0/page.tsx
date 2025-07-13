import Image from "next/image";



//export default function Page() {
//  return <div>Page</div>
//}

import { MeuNome } from "@/components/MeuNome";
import { Hobbies } from "@/components/Hobbies";
import { Imagem } from "@/components/Imagem";


const Page = () => (
  
        <div> 
          <MeuNome name={"Fábio Higor"} age={33} birtDate={new Date(1992, 1, 11)}/>
          <Hobbies />
          <Imagem />
        </div>

);

export default Page;